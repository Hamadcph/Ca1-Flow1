package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
{
    @NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke"),
    @NamedQuery(name = "Joke.getAllJokes", query = "SELECT r FROM Joke r")
})

public class Joke implements Serializable {

    public Joke(long id, String jokeContent, String jokeType)
    {
        this.id = id;
        this.jokeContent = jokeContent;
        this.jokeType = jokeType;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jokeContent;
    private String jokeType;

    public String getJokeContent()
    {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent)
    {
        this.jokeContent = jokeContent;
    }

    public String getJokeType()
    {
        return jokeType;
    }

    public void setJokeType(String jokeType)
    {
        this.jokeType = jokeType;
    }

    public Joke()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}
