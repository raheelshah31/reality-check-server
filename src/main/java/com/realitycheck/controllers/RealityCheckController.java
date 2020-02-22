package com.realitycheck.controllers;


import com.realitycheck.dao.RealityCheckDao;
import com.realitycheck.model.Scoops;
import com.realitycheck.repository.ScoopRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/scoops")
public class RealityCheckController {

    private final RealityCheckDao realityCheckDao;

    @Autowired
    private RealityCheckController(RealityCheckDao realityCheckDao) {
        this.realityCheckDao = realityCheckDao;
    }

    @Autowired
    private ScoopRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Scoops> getAllScoops() {
        return repository.findAll(new PageRequest(0,1000));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Scoops getScoopById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public int verifyNews(@Valid @RequestBody String scoopText) {
        return realityCheckDao.KNNModifiedClassifier(scoopText,100);
    }
}