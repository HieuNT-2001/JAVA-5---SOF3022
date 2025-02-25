package com.fpoly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpoly.model.XeMay;
import com.fpoly.repository.XeMayRepository;

@Service
public class XeMayService {

    private final XeMayRepository xeMayRepository;

    public XeMayService(XeMayRepository xeMayRepository) {
        this.xeMayRepository = xeMayRepository;
    }

    public List<XeMay> getAllXeMay() {
        return xeMayRepository.findAll();
    }

    public XeMay getXeMayById(int id) {
        return xeMayRepository.findById(id).orElse(null);
    }

    public XeMay saveXeMay(XeMay xeMay) {
        return xeMayRepository.save(xeMay);
    }

    public void deleteXeMay(int id) {
        xeMayRepository.deleteById(id);
    }
}
