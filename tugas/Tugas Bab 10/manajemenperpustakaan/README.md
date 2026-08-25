# Sistem Manajemen Perpustakaan - REST API

Aplikasi Sistem Manajemen Perpustakaan ini dibangun menggunakan **Java Spring Boot**, **Spring Data JPA**, dan **MySQL Database** sebagai implementasi tugas CRUD REST API.

## Teknologi & Depedensi
- **Java**: Version 17
- **Framework**: Spring Boot 3.4.x / 4.x
- **ORM**: Spring Data JPA / Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **Lombok**

## Konfigurasi Database
1. Buat database di MySQL dengan nama `db_perpustakaan` (atau otomatis dibuat oleh Spring Boot jika menggunakan flag `createDatabaseIfNotExist=true`).
2. Sesuaikan konfigurasi di `src/main/resources/application.properties` jika username/password MySQL berbeda:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_perpustakaan?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
```

## Cara Jalankan Aplikasi
1. Clone / download project ini.
2. Buka terminal pada root directory project.
3. Jalankan perintah berikut untuk meng-compile dan menjalankan aplikasi:
   ```bash
   ./mvnw spring-boot:run
   ```
   *(atau `mvn clean spring-boot:run` jika Maven telah terinstall di sistem)*.
4. Aplikasi akan berjalan pada `http://localhost:8080`.

## Endpoint API

### 1. Kategori API (`/api/kategori`)
- `GET /api/kategori` : Mengambil semua data kategori
- `GET /api/kategori/{id}` : Mengambil data kategori berdasarkan ID
- `POST /api/kategori` : Menambahkan kategori baru
- `PUT /api/kategori/{id}` : Mengubah data kategori berdasarkan ID
- `DELETE /api/kategori/{id}` : Menghapus data kategori berdasarkan ID

### 2. Buku API (`/api/buku`)
- `GET /api/buku` : Mengambil semua data buku
- `GET /api/buku/{id}` : Mengambil data buku berdasarkan ID
- `POST /api/buku` : Menambahkan buku baru
- `PUT /api/buku/{id}` : Mengubah data buku berdasarkan ID
- `DELETE /api/buku/{id}` : Menghapus data buku berdasarkan ID

## Postman Collection
File Postman Collection disertakan di root directory project: `Manajemen_Perpustakaan.postman_collection.json`.
Silakan import file tersebut ke Postman untuk langsung menguji seluruh endpoint CRUD (Create, Read, Update, Delete, serta penanganan 404 Data Tidak Ditemukan).
