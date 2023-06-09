package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
class PublisherFormController {

    private final PublisherService publisherService;

    @GetMapping(path = "/publisher/add")
    String showAddPublisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }
    // create author
    @PostMapping(path = "/publisher/add")
    String processAddPublisherForm(@Valid Publisher publisher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "publisher/add";
        }

        publisherService.save(publisher);

        return "redirect:/publisher/list";
    }

    @GetMapping(path = "/publisher/edit")
    String showEditPublisherForm(@RequestParam Long id, Model model) {

        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher", publisher);
        return "publisher/edit";
    }
    // create author
    @PostMapping(path = "/publisher/edit")
    String processEditPublisherForm(@Valid Publisher publisher, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "publisher/edit";
        }

        publisherService.update(publisher);

        return "redirect:/publisher/list";
    }

    @GetMapping(path = "/publisher/remove")
    String processRemovePublisher(@RequestParam Long id) {

        publisherService.deleteById(id);

        return "redirect:/publisher/list";
    }

    @GetMapping(path = "/publisher/list")
    String showAllPublishers(Model model) {

        List<Publisher> publishers = publisherService.findAll();

        model.addAttribute("publishers", publishers);

        return "publisher/list";
    }
}
