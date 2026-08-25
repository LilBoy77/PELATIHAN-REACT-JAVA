package com.sistem.manajemenperpustakaan.controller;

import com.sistem.manajemenperpustakaan.entity.Kategori;
import com.sistem.manajemenperpustakaan.service.KategoriService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {

    private final KategoriService kategoriService;

    public KategoriController(KategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Kategori>>> getAllKategori() {
        List<Kategori> data = kategoriService.getAllKategori();
        ApiResponse<List<Kategori>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil mengambil semua data kategori",
                data
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Kategori>> getKategoriById(@PathVariable Long id) {
        Kategori data = kategoriService.getKategoriById(id);
        ApiResponse<Kategori> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil mengambil data kategori dengan ID: " + id,
                data
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Kategori>> createKategori(@RequestBody Kategori kategori) {
        Kategori data = kategoriService.createKategori(kategori);
        ApiResponse<Kategori> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Berhasil menambahkan kategori baru",
                data
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Kategori>> updateKategori(@PathVariable Long id, @RequestBody Kategori kategori) {
        Kategori data = kategoriService.updateKategori(id, kategori);
        ApiResponse<Kategori> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil memperbarui data kategori dengan ID: " + id,
                data
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteKategori(@PathVariable Long id) {
        kategoriService.deleteKategori(id);
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil menghapus kategori dengan ID: " + id,
                "Data kategori berhasil dihapus"
        );
        return ResponseEntity.ok(response);
    }
}
