package net.slowvic.oxm;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.slowvic.domain.User;
import net.slowvic.util.AppContextUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

@Component
public class OxmUser {

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    public static void main(String[] args) throws XmlMappingException,
        IOException {
        ApplicationContext appContext = AppContextUtil.getApplicationContext();
        OxmUser oxm = appContext.getBean(OxmUser.class);
        User user = oxm.createUser();
        String result = oxm.marshallUser(user);
        User unUser = oxm.unMarshallUser(result);
        System.out.println(user.equals(unUser));
    }

    private User createUser() {
        User user = new User();
        user.setUserName("塘檐");
        user.setPassword("@#sdfa^%");
        user.setBirthday(new Date());
        return user;
    }

    public String marshallUser(User user) throws XmlMappingException,
        IOException {
        Writer writer = new StringWriter();
        Result streamResult = new StreamResult(writer);
        marshaller.marshal(user, streamResult);
        String result = writer.toString();
        writer.close();
        return result;
    }

    public User unMarshallUser(String result) throws XmlMappingException,
        IOException {
        Reader reader = new StringReader(result);
        Source source = new StreamSource(reader);
        User user = (User) unmarshaller.unmarshal(source);
        reader.close();
        return user;
    }
}
