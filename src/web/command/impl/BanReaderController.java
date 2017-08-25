package web.command.impl;

import entities.Reader;
import service.ReaderService;
import service.impl.ReaderServiceImpl;
import web.command.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BanReaderController implements Controller {
    private ReaderService readerService = ReaderServiceImpl.getInstance();//todo unban

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Reader reader = readerService.get(Integer.parseInt(req.getParameter("readerID")));
        if (reader.getStatus().equals("BANNED")) {
            reader.setStatus("");
        } else {
            reader.setStatus("BANNED");
        }
        System.out.println("Status: " + reader.getStatus());
        readerService.update(reader);
        Reader newReader = readerService.get(reader.getReaderID());
        System.out.println("Status2: " + newReader.getStatus());
    }
}
