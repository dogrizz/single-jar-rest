package hello.domain;

import javax.persistence.*;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "greeting")
    @SequenceGenerator(name = "greeting", sequenceName = "seq_greeting")
    private long id;

    @Column(name = "content",nullable = false)
    private String content;

    public Greeting() {

    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
