package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Controlador {

    @PostMapping("/register_cellphone")
    public Cellphone register_cellphone(@RequestBody Cellphone cellphone) throws SQLException, ClassNotFoundException {

        String code = cellphone.getCode();
        String brand = cellphone.getBrand();
        String name = cellphone.getName();
        String ram = cellphone.getRam();
        String storage = cellphone.getStorage();
        String color = cellphone.getColor();

        if (code == null || code.equals("") || code.length() < 0 || brand == null || brand.equals("") || brand.length() < 0 ||
                name == null || name.equals("") || name.length() < 0 || ram == null || ram.equals("") || ram.length() < 0
                ||storage == null || storage.equals("") || storage.length() < 0 || color == null || color.equals("") ||
                color.length() < 0 ) {

            return new Cellphone(null,null,null, null, null, null);
        } else {
                BD bd = new BD();
                String brand_bd = BD.select_brand(brand);

                if (brand_bd.equals("")){
                return new Cellphone(null,Errors.brand,null,null,null, null);
            }else{
                bd = new BD();
                cellphone = bd.register(code, brand, name, ram, storage, color);
            }
        }
        return cellphone;
    }
    @PostMapping("/edit_cellphone")
    public Cellphone edit_cellphone(@RequestBody Cellphone cellphone) throws SQLException, ClassNotFoundException {

        String code = cellphone.getCode();
        String brand = cellphone.getBrand();
        String name = cellphone.getName();
        String ram = cellphone.getRam();
        String storage = cellphone.getStorage();
        String color = cellphone.getColor();

        if (code == null || code.equals("") || code.length() < 0 || brand == null || brand.equals("") || brand.length() < 0 ||
                name == null || name.equals("") || name.length() < 0 || ram == null || ram.equals("") || ram.length() < 0
                ||storage == null || storage.equals("") || storage.length() < 0 || color == null || color.equals("") ||
                color.length() < 0 ) {

            return new Cellphone(null,null,null, null, null, null);
        } else {
            BD bd = new BD();
            String brand_bd = BD.select_brand(brand);

            if (brand_bd.equals("")){
                return new Cellphone(null,Errors.edit_brand,null,null,null, null);
            }else{
                bd = new BD();
                cellphone = bd.edit(code, brand, name, ram, storage, color);
            }
        }
        return cellphone;
    }
    @GetMapping("/search/{code}")
    public Cellphone search_cellphone(@PathVariable String code) throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        Cellphone cellphone;

        if (code == null || code.equals("") || code.length() < 0) {

            return new Cellphone(Errors.error_seacrh_one, null, null, null, null, null);

        } else {
            cellphone = BD.Select_cellphone(code);
        }
        return cellphone;
    }
    @GetMapping("/search_all")
    public List<Cellphone> search() throws SQLException, ClassNotFoundException {

        BD bd = new BD();
        List<Cellphone> list = bd.search();

        return list;
    }
    @DeleteMapping("/delete")
    public Cellphone delete(@RequestBody Cellphone cellphone) throws SQLException, ClassNotFoundException {

        String code = cellphone.getCode();
        if (cellphone.getCode() == null || cellphone.getCode().equals("") || cellphone.getCode().length() < 0) {
            return new Cellphone(null, null, null, null, null, null);
        } else {

            int f = BD.Delete(code);
            if (f == 0) {
                return new Cellphone(Errors.error_delete, null, null, null, null, null);
            }
        }

        return cellphone;
    }
    }

