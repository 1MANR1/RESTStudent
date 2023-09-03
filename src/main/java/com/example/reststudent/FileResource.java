package com.example.reststudent;

import com.example.reststudent.myfiles.FileClass;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Path("/files")
public class FileResource {

    @GET
    @Produces("text/plain")
    public String allFiles(){
        String data = "\n";
        for (String name: FileClass.names) {
            data += name;
        }
        return data;
    }


    @GET
    @Path("/{name}")
    @Produces("text/plain") // pdf, image possible
    public Response get_file(@PathParam("name") String name){
        File file = new File("C:\\Users\\imanr\\IdeaProjects\\RESTStudent\\src\\main\\java\\com\\example\\reststudent\\myfiles\\"+name+".txt");
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Contebt-description", "attachment; filename=FisplayName-demoFile.txt");
        FileClass.names.add(name);
        return response.build();
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String upload_file(
            @FormDataParam("file") InputStream uploadInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail
            ){
        saveToDisk(uploadInputStream, fileDetail);
        return "File uploaded";
    }

    private void saveToDisk(InputStream uploadInputStream,FormDataContentDisposition fileDetail){
        String uploadFileLocation = "C:\\User\\imanr\\IdeaProjects\\RESTStudent\\src\\main\\java\\com\\example\\reststudent\\myfiles\\" +fileDetail.getFileName();
        try {
            OutputStream out = new FileOutputStream(new File(
                    uploadFileLocation
            ));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadFileLocation));
            while((read = uploadInputStream.read(bytes)) != -1 ){
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
