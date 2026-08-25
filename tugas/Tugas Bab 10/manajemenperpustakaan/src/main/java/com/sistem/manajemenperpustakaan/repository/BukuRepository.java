package com.sistem.manajemenperpustakaan.repository;

import com.sistem.manajemenperpustakaan.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByKategoriId(Long kategoriId);
}
