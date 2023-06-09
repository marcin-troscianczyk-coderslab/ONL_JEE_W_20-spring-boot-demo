package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;

@Controller
@RequiredArgsConstructor
class PersonController {

    private final PersonService personService;

    @GetMapping(path = "/form")
    String showAddForm() {
        return "person/form";
    }

    @PostMapping(path = "/form")
    @ResponseBody
    String processAddForm(Person person) {

        personService.save(person);

        return person.toString();

    }
}
