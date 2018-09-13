package com.myuserid.controller;

import com.myuserid.pojo.dbentity.StShopDataAnchor;
import com.myuserid.pojo.request.IdRequest;
import com.myuserid.pojo.request.ShopDataAnchorRequest;
import com.myuserid.pojo.response.APIResponse;
import com.myuserid.pojo.response.ShopDataAnchorResponse;
import com.myuserid.service.IShopDataAnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/7/13.
 * StShopDataAnchor Controller
 */
@RequestMapping("/shopdataanchor")
@RestController
public class StShopDataAnchorController {

    private final IShopDataAnchorService shopDataAnchorService;

    @Autowired
    public StShopDataAnchorController(IShopDataAnchorService shopDataAnchorService) {
        this.shopDataAnchorService = shopDataAnchorService;
    }

    @RequestMapping("/getBatch")
    public ResponseEntity<APIResponse<List<StShopDataAnchor>>> getBatch() {
        APIResponse<List<StShopDataAnchor>> shopDataAnchorResponseList = shopDataAnchorService.getAnchorList();
        return new ResponseEntity<>(shopDataAnchorResponseList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<APIResponse<StShopDataAnchor>> getById(@RequestBody IdRequest id) {
        APIResponse<StShopDataAnchor> response = shopDataAnchorService.getById(id.getId());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<APIResponse<StShopDataAnchor>> update(@RequestBody ShopDataAnchorRequest request) {
        APIResponse<StShopDataAnchor> response = shopDataAnchorService.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
