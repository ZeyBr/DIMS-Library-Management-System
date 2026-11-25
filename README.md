
```markdown
# 📚 Modern Kütüphane Yönetim Sistemi (Library Management System)

Spring Boot ve modern web teknolojileri kullanılarak geliştirilmiş; endüstri standardı katmanlı mimariye, gelişmiş hata yönetim mekanizmasına, harici API entegrasyonlarına ve **Neo-brutalism** tasarım diline sahip tam teşekküllü bir kütüphane yönetim uygulamasıdır.

---

## 🏗️ Proje Mimarisi ve Katmanlı Yapı

Bu projede sürdürülebilir, modüler ve test edilebilir kod yazmak amacıyla **Katmanlı Mimari (Layered Architecture)** prensipleri benimsenmiştir:

*   **Controller Katmanı (`/controller`):** İstemciden (`frontend`) gelen HTTP isteklerini (`GET`, `POST`, `DELETE`) karşılar ve ilgili servis katmanına yönlendirir.
*   **Service Katmanı (`/service`):** İş mantığının (`business logic`) yönetildiği, verinin işlendiği ve hata kontrollerinin yapıldığı merkezdir.
*   **Repository Katmanı (`/repository`):** Spring Data JPA (`JpaRepository`) kullanarak veritabanı ile doğrudan iletişim kurar, SQL sorgularını otomatik yönetir.
*   **Entity Katmanı (`/entity`):** Veritabanındaki tabloları (`authors`, `books`, `borrows`) ve aralarındaki ilişkileri temsil eden nesnelerdir.
*   **DTO Katmanı (`/dto`):** Veritabanı varlıklarını doğrudan dış dünyaya açmamak, güvenlik sağlamak ve veri transferini optimize etmek için kullanılan nesnelerdir.
*   **Mapper Katmanı (`/mapper`):** Entity nesneleri ile DTO nesneleri arasındaki dönüşümleri güvenli bir şekilde gerçekleştiren sınıftır.
*   **Exception Katmanı (`/exception`):** Sistem genelinde oluşabilecek hataları yakalayan ve anlamlı HTTP durum kodları (`404`, `409`) üreten özel yapıktır.

---

## 🛠️ Kullanılan Teknolojiler ve Araçlar

*   **Backend:** Java, Spring Boot, Spring Data JPA, Spring Web, Lombok
*   **Veritabanı:** İlişkisel Veritabanı Yönetimi (JPA / Hibernate)
*   **Frontend:** HTML5, CSS3 (Neo-brutalism / Soft-pop tasarım dili), Vanilla JavaScript (Fetch API)
*   **Harici API:** Open Library API (Kitap başlıklarına göre dinamik kapak fotoğraflarının çekilmesi)
*   **Versiyon Kontrol:** Git & GitHub

---

## API Tests

Run the tests from the project root with Java 21 and Maven:

```bash
mvn test
```

`BookControllerTest` covers two cases for `GET /api/books/{id}`:

- Existing book: returns `200 OK` and the requested book ID in the JSON response.
- Missing book: returns `404 Not Found`.

The controller tests use MockMvc and Mockito and run without MySQL.
GitHub Actions runs the tests on pull requests.

## 📂 Proje Dizin Yapısı

```text
src/
│
├── main/
    ├── java/zey/library_managament/
    │   ├── Controller/       # REST API uç noktaları (Author, Book, Borrow)
    │   ├── DTO/              # Veri transfer nesneleri (AuthorDTO, BookDTO, BorrowDTO)
    │   ├── Entity/           # Veritabanı varlıkları (Author, Book, Borrow)
    │   ├── Exception/        # Özel hata sınıfları (ResourceNotFoundException vb.)
    │   ├── Mapper/           # Entity <-> DTO dönüşüm merkezi (LibraryMapper)
    │   ├── Repository/       # JPA Veritabanı arayüzleri
    │   └── Service/          # İş mantığı ve Impl katmanları
    │
    └── resources/
        ├── static/           # Arayüz dosyaları (index.html, style.css, app.js)
        └── application.properties # Veritabanı ve sunucu ayarları

```

---

## ✨ Temel Özellikler ve Modüller

* **Yazar Yönetimi:**
* Yeni yazar kaydı oluşturma.
* Mevcut yazarları listeleme ve silme.
* Ödünç verme formunda yazar seçimi için dinamik açılır liste (dropdown) entegrasyonu.


* **Kitap Yönetimi:**
* Kitap adı ve yayın yılı ile kayıt oluşturma.
* **Open Library API** entegrasyonu sayesinde girilen kitap adından yola çıkarak kapak fotoğraflarının arayüze anlık olarak getirilmesi.


* **Ödünç Alma ve İade Modülü:**
* Yazar ve kitap seçimi yaparak ödünç kaydı oluşturma.
* Ödünç alma tarihi ve iade (geri getirme) tarihi belirleme.
* Tabloda karmaşık ID numaraları yerine; **yazar adı, kitap adı, ödünç/iade tarihleri ve kitap kapağının** görsel olarak sergilenmesi.
* Aktif ödünç kayıtlarını **"İptal Et"** butonu ile sistemden güvenle sikebilme.


* **Güçlü Hata Yönetimi:**
* Veritabanında bulunmayan kaynaklar için **`404 Not Found`** (`ResourceNotFoundException`).
* Çakışmalar ve geçersiz durumlar için anlamlı HTTP hata kodları.



---

## 🚀 Kurulum ve Çalıştırma

Projeyi yerel bilgisayarınızda çalıştırmak için şu adımları izleyebilirsiniz:

1. **Projeyi Klonlayın:**
```bash
git clone <proje-reposu-linki>

```


2. **IDE ile Açın:**
* Projeyi **IntelliJ IDEA** içerisinden açın.
* Maven bağımlılıklarının (`pom.xml`) otomatik olarak yüklenmesini bekleyin.


3. **Uygulamayı Çalıştırın:**
* `src/main/java/zey/library_managament/LibraryManagementApplication.java` sınıfını açın ve **Run** tuşuna basın.


4. **Tarayıcıda Görüntüleyin:**
* Tarayıcınızı açın ve şu adrese gidin:
```text
http://localhost:8080

```





---

## 🎨 Tasarım Anlayışı (Neo-brutalism)

Arayüz tasarımında modern web ve mobil tasarım trendlerinden ilham alınmıştır; kalın siyah çerçeveler (`2px solid #1E1E1E`), pastel tonlar (lila, nane yeşili, şeftali), yumuşak köşeler ve sert gölge efektleriyle hem eğlenceli hem de son derece modern bir kullanıcı deneyimi hedeflenmiştir.

