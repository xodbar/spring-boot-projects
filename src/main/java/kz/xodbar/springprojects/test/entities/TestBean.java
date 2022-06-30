package kz.xodbar.springprojects.test.entities;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
    private String text = "Hello";

    public TestBean() {
        System.out.println("CREATING TEST BEAN");
    }

    public void setText(String text) {
        this.text=text;
    }

    public String getData() {
        return ("This is " + text + " data.");
    }
}
