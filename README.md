# 📚 Modern Kütüphane Yönetim Sistemi (Library Management System)

Spring Boot ve modern web teknolojileri kullanılarak geliştirilmiş; katmanlı mimariye, gelişmiş hata yönetim mekanizmasına ve **Neo-brutalism** tasarım diline sahip tam teşekküllü bir kütüphane yönetim uygulamasıdır.

---

## 🚀 Proje Mimarisi ve Kullanılan Teknolojiler

Bu projedeendüstri standardı olan **Katmanlı Mimari (Layered Architecture)** prensipleri benimsenmiştir:

*   **Backend:** Java, Spring Boot (Spring Data JPA, Spring Web)
*   **Veri Yönetimi:** Lombok, Map/Manual DTO & Mapper Pattern
*   **Hata Yönetimi (Exception Handling):** Özel HTTP durum kodları (`@ResponseStatus` ile 404 Not Found, 409 Conflict)
*   **Frontend:** HTML5, CSS3 (Neo-brutalism / Soft-pop tasarım akımı), Vanilla JavaScript (Fetch API)
*   **Harici Entegrasyon:** Open Library API (Kitap kapaklarının dinamik olarak çekilmesi)

---

## 📂 Proje Dizin Yapısı

```text
src/
│
├── main/
    ├── java/zey/library_managament/
    │   ├── Controller/       # REST API uç noktaları (Author, Book, Borrow)
    │   ├── DTO/              # Veri transfer nesneleri (Data Transfer Objects)
    │   ├── Entity/           # Veritabanı varlık sınıfları (Author, Book, Borrow)
    │   ├── Exception/        # Özel hata sınıfları (ResourceNotFoundException vb.)
    │   ├── Mapper/           # Entity <-> DTO dönüşüm merkezi
    │   ├── Repository/       # Veritabanı iletişim arayüzleri (Spring Data JPA)
    │   └── Service/          # İş mantığı arayüzleri ve Impl katmanı
    │
    └── resources/
        ├── static/           # Arayüz dosyaları (index.html, style.css, app.js)
        └── application.properties # Uygulama konfigürasyonları
