package com.sistem.manajemenperpustakaan.controller;

import com.sistem.manajemenperpustakaan.entity.Buku;
import com.sistem.manajemenperpustakaan.service.BukuService;
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
@RequestMapping("/api/buku")
public class BukuController {

    private final BukuService bukuService;

    public BukuController(BukuService bukuService) {
        this.bukuService = bukuService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Buku>>> getAllBuku() {
        List<Buku> data = bukuService.getAllBuku();
        ApiResponse<List<Buku>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil mengambil semua data buku",
                data
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/kategori/{kategoriId}")
    public ResponseEntity<ApiResponse<List<Buku>>> getBukuByKategoriId(@PathVariable Long kategoriId) {
        List<Buku> data = bukuService.getBukuByKategoriId(kategoriId);
        ApiResponse<List<Buku>> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil mengambil data buku berdasarkan ID kategori: " + kategoriId,
                data
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Buku>> getBukuById(@PathVariable Long id) {
        Buku data = bukuService.getBukuById(id);
        ApiResponse<Buku> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil mengambil data buku dengan ID: " + id,
                data
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Buku>> createBuku(@RequestBody Buku buku) {
        Buku data = bukuService.createBuku(buku);
        ApiResponse<Buku> response = new ApiResponse<>(
                HttpStatus.CREATED.value(),
                "Berhasil menambahkan buku baru",
                data
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Buku>> updateBuku(@PathVariable Long id, @RequestBody Buku buku) {
        Buku data = bukuService.updateBuku(id, buku);
        ApiResponse<Buku> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil memperbarui data buku dengan ID: " + id,
                data
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBuku(@PathVariable Long id) {
        bukuService.deleteBuku(id);
        ApiResponse<String> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Berhasil menghapus buku dengan ID: " + id,
                "Data buku berhasil dihapus"
        );
        return ResponseEntity.ok(response);
    }
}
