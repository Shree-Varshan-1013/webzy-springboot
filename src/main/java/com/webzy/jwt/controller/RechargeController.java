package com.webzy.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webzy.jwt.entity.Recharge;
import com.webzy.jwt.service.RechargeServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recharges")
public class RechargeController {

    private final RechargeServiceImpl rechargeService;
    
    @GetMapping("/")
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @GetMapping("/{id}")
    public Recharge getRechargeById(@PathVariable Long id) {
        return rechargeService.getRechargeById(id);
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> createRecharge(@PathVariable("username") String username, @RequestBody Recharge recharge) {
        return rechargeService.createRecharge(username, recharge);
    }

    @PostMapping("/{username}/{mobileNumber}")
    public ResponseEntity<String> createRechargeForOthers(@PathVariable("username") String username,@PathVariable("mobileNumber") Long mobileNumber, @RequestBody Recharge recharge) {
        return rechargeService.createRechargeForOthers(username, mobileNumber, recharge);
    }

    @PutMapping("/{id}")
    public Recharge updateRecharge(@PathVariable Long id, @RequestBody Recharge recharge) {
        return rechargeService.updateRecharge(id, recharge);
    }

    @DeleteMapping("/{id}")
    public void deleteRecharge(@PathVariable Long id) {
        rechargeService.deleteRecharge(id);
    }
}
