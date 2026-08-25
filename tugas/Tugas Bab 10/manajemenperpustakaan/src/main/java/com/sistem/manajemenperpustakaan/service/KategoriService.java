package com.sistem.manajemenperpustakaan.service;

import com.sistem.manajemenperpustakaan.entity.Kategori;
import com.sistem.manajemenperpustakaan.repository.KategoriRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService {

    private final KategoriRepository kategoriRepository;

    public KategoriService(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    public List<Kategori> getAllKategori() {
        return kategoriRepository.findAll();
    }

    public Kategori getKategoriById(Long id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori tidak ditemukan dengan ID: " + id));
    }

    public Kategori createKategori(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    public Kategori updateKategori(Long id, Kategori kategoriDetails) {
        Kategori kategori = getKategoriById(id);
        kategori.setNama(kategoriDetails.getNama());
        kategori.setDeskripsi(kategoriDetails.getDeskripsi());
        return kategoriRepository.save(kategori);
    }

    public void deleteKategori(Long id) {
        Kategori kategori = getKategoriById(id);
        kategoriRepository.delete(kategori);
    }
}
