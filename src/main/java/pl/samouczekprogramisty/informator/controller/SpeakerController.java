package pl.samouczekprogramisty.informator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.samouczekprogramisty.informator.model.dao.SpeakerDAO;
import pl.samouczekprogramisty.informator.view.SpeakerView;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {

    private static final Logger LOG = LoggerFactory.getLogger(SpeakerController.class);

    @Autowired
    private SpeakerDAO dao;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SpeakerView speaker(@PathVariable("id") Integer id) {
        System.out.println("xxx: " + id);
        LOG.debug("Processing id: " + id);
        return new SpeakerView(dao.get(id));
    }
}

