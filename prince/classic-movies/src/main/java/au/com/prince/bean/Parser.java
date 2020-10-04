package au.com.prince.bean;

import org.springframework.stereotype.Component;

@Component
public class Parser {

    public String getIdNumber(String movieId) throws Exception {
        try {
            String temp = movieId.substring(2);
            return temp;
        } catch (Exception e) {
            return e.toString();
        }
    }

}
