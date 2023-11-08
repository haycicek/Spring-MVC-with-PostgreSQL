package com.project.web.controller;

import com.project.web.dto.BrandDto;
import com.project.web.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/getall")
    List<BrandDto> listBrands(Model model){
        List<BrandDto> brands = brandService.findAllBrands();
        model.addAttribute("brands", brands);
        return brands;
    }

    @PostMapping("/brands/new")
    public String saveBrand(@RequestBody() @Valid BrandDto brandDto,
                            BindingResult result, Model model){
        brandService.saveBrand(brandDto);
        return "Brand saved";
    }

    @DeleteMapping("/brands/{brandId}/delete")
    public String deleteBrand(@PathVariable("brandId")int brandId){
        brandService.delete(brandId);
        return "The brand at this ID : "+brandId+" was deleted";
    }

    @PutMapping("/brands/{brandId}/edit")
    public String updateBrand(@PathVariable("brandId") int brandId,
                              @RequestBody() @Valid() BrandDto brand,
                              BindingResult result, Model model){
        brand.setId(brandId);
        brandService.updateBrand(brand);
        return "The brand at this ID : "+brandId+" was updated";
    }

}
