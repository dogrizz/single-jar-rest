package hello.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.domain.Greeting;
import hello.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @RequestMapping(path="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(path="/db_greetings", method=RequestMethod.GET)
    public List<Greeting> greetingsList() {
        return greetingRepository.findAll();
    }

    @RequestMapping(path="/db_greeting", method=RequestMethod.GET)
    public Greeting getGreeting(@RequestParam(value = "id") Long id) {
        return greetingRepository.find(id);
    }

    @RequestMapping(path="/db_greeting", method=RequestMethod.PUT)
    public Long addGreeting(@RequestParam(value = "content") String content) {
        return greetingRepository.save(content);
    }

}
