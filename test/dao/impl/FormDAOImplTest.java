package dao.impl;

import dao.FormDAO;
import entities.Form;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FormDAOImplTest {

    @Test
    public void saveAndGetByReceivalType() throws Exception {
        FormDAO formDAO = FormDAOImpl.getInstance();
        Form form = new Form();
        form.setBookID(5);
        form.setReaderID(3);
        form.setLibrarianID(2);
        form.setReceivalType("Формуляр");
        Calendar calendar = new GregorianCalendar();
        form.setReceivalDate(new Date(calendar.getTimeInMillis()));
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        form.setReturnDate(new Date(calendar.getTimeInMillis()));
        form = formDAO.save(form);
        Form newForm = formDAO.getByReceivalType("Формуляр").get(0);
        Assert.assertEquals(form.toString(), newForm.toString());
        formDAO.delete(newForm.getFormID());
    }


    @Test
    public void getAndUpdate() throws Exception {
        FormDAO formDAO = FormDAOImpl.getInstance();
        Form form = new Form();
        form.setBookID(5);
        form.setReaderID(3);
        form.setLibrarianID(2);
        form.setReceivalType("АБОНЕМЕНТ");
        Calendar calendar = new GregorianCalendar();
        form.setReceivalDate(new Date(calendar.getTimeInMillis()));
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        form.setReturnDate(new Date(calendar.getTimeInMillis()));
        form = formDAO.save(form);
        form.setReceivalType("Формуляр");
        formDAO.update(form);
        Form newForm = formDAO.get(form.getFormID());
        Assert.assertEquals(form.toString(), newForm.toString());
        formDAO.delete(form.getFormID());
    }

    @Test
    public void getAllAndDelete() throws Exception {
        FormDAO formDAO = FormDAOImpl.getInstance();
        Form form = new Form();
        form.setBookID(5);
        form.setReaderID(3);
        form.setLibrarianID(2);
        form.setReceivalType("Формуляр");
        Calendar calendar = new GregorianCalendar();
        form.setReceivalDate(new Date(calendar.getTimeInMillis()));
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        form.setReturnDate(new Date(calendar.getTimeInMillis()));
        form = formDAO.save(form);
        List<Form> forms = formDAO.getAll();
        int oldSize = forms.size();
        formDAO.delete(form.getFormID());
        forms = formDAO.getAll();
        Assert.assertEquals(oldSize - 1, forms.size());
    }

}