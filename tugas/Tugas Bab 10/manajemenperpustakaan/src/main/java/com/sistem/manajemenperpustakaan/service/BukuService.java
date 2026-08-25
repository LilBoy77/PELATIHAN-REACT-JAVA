package com.sistem.manajemenperpustakaan.service;

import com.sistem.manajemenperpustakaan.entity.Buku;
import com.sistem.manajemenperpustakaan.entity.Kategori;
import com.sistem.manajemenperpustakaan.repository.BukuRepository;
import com.sistem.manajemenperpustakaan.repository.KategoriRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    private final BukuRepository bukuRepository;
    private final KategoriRepository kategoriRepository;

    public BukuService(BukuRepository bukuRepository, KategoriRepository kategoriRepository) {
        this.bukuRepository = bukuRepository;
        this.kategoriRepository = kategoriRepository;
    }

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    public List<Buku> getBukuByKategoriId(Long kategoriId) {
        return bukuRepository.findByKategoriId(kategoriId);
    }

    public Buku getBukuById(Long id) {
        return bukuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buku tidak ditemukan dengan ID: " + id));
    }

    public Buku createBuku(Buku buku) {
        if (buku.getKategori() != null && buku.getKategori().getId() != null) {
            Long kategoriId = buku.getKategori().getId();
            Kategori kategori = kategoriRepository.findById(kategoriId)
                    .orElseThrow(() -> new ResourceNotFoundException("Kategori tidak ditemukan dengan ID: " + kategoriId));
            buku.setKategori(kategori);
        }
        return bukuRepository.save(buku);
    }

    public Buku updateBuku(Long id, Buku bukuDetails) {
        Buku buku = getBukuById(id);
        buku.setJudul(bukuDetails.getJudul());
        buku.setPenulis(bukuDetails.getPenulis());
        buku.setPenerbit(bukuDetails.getPenerbit());
        buku.setTahunTerbit(bukuDetails.getTahunTerbit());
        buku.setIsbn(bukuDetails.getIsbn());
        buku.setStok(bukuDetails.getStok());

        if (bukuDetails.getKategori() != null && bukuDetails.getKategori().getId() != null) {
            Long kategoriId = bukuDetails.getKategori().getId();
            Kategori kategori = kategoriRepository.findById(kategoriId)
                    .orElseThrow(() -> new ResourceNotFoundException("Kategori tidak ditemukan dengan ID: " + kategoriId));
            buku.setKategori(kategori);
        } else {
            buku.setKategori(null);
        }

        return bukuRepository.save(buku);
    }

    public void deleteBuku(Long id) {
        Buku buku = getBukuById(id);
        bukuRepository.delete(buku);
    }
}
