# 📱 Praktikum MP #04 — App Navigation (Navio)

## 👤 Identitas

* **Nama**  : Nor Hayati
* **NIM**   : 230104040203
* **Kelas** : TI23A
* **Mata Kuliah** : Mobile Programming

## Deskripsi

Project **Navio** merupakan hasil Praktikum Mobile Programming #4 dengan topik **Menggunakan Navigasi Aplikasi Android**. Aplikasi ini dibangun sepenuhnya menggunakan **Jetpack Compose** dan **Navigation Compose**, dengan tujuan memahami konsep navigasi modern Android seperti Intent, pengiriman data, Back Stack, Fragment-style navigation, serta penerapan Material Design 3.

Project ini dibuat sebagai bagian dari tugas **mata kuliah Mobile Programming**.

---

## 🎯 Tujuan Praktikum

* Memahami navigasi antar Activity menggunakan Intent eksplisit
* Mengirim dan menerima data antar layar
* Memahami Activity Lifecycle dan Back Stack
* Mengimplementasikan navigasi bertingkat (multi-step)
* Menggunakan **Jetpack Compose Navigation**
* Mengombinasikan Activity dan Fragment (Bottom Navigation)
* Menerapkan **Material Design 3**
* Menerapkan tema (Light/Dark/System) dan lokalisasi (ID/EN)
* Menyimpan state menggunakan **DataStore**

---

## 🛠️ Tools & Teknologi

* **Android Studio** Narwhal | 2025.1.1
* **Kotlin**
* **Jetpack Compose**
* **Material Design 3**
* **Navigation Compose**
* **DataStore Preferences**
* **Minimum SDK**: 24 (Android 7.0)
* **Compile / Target SDK**: 35

---

## 📦 Dependency Utama

```bash
Jetpack Compose BOM : 2024.10.01
Navigation Compose  : 2.8.3
Material3           : androidx.compose.material3
Lifecycle            : 2.8.6
DataStore            : 1.1.1
`````

---

## 🗂️ Struktur Project

```bash
p4appnavigation_230104040203/
├── README.md
├── hasiluji/
│   ├── 1.jpeg
│   ├── 2.jpeg
│   ├── 3.jpeg
│   ├── 4.jpeg
│   ├── 5.jpeg
│   ├── 6.jpeg
│   ├── 7.jpeg
│   ├── 8.jpeg
│   ├── 9.jpeg
│   ├── 10.jpeg
│   ├── 11.jpeg
│   ├── 12.jpeg
│   ├── 13.jpeg
│   └── 14.jpeg
│   
├── app/
│   ├── build/
│   └── src/
│       ├── androidTest/
│       └── main/
│           ├── java/id/antasari/p4appnavigation_230104040203/
│           │   ├── data/
│           │   ├── nav/
│           │   │   ├── NavGraph.kt
│           │   │   └── Routes.kt
│           │   ├── screens/
│           │   │   ├── ActivityA_B.kt
│           │   │   ├── ActivityC_D.kt
│           │   │   ├── BackStackScreens.kt
│           │   │   ├── HomeScreen.kt
│           │   │   └── HubScreens.kt
│           │   ├── ui/theme/
│           │   │   ├── Color.kt
│           │   │   ├── Theme.kt
│           │   │   └── Type.kt
│           │   ├── viewmodel/
│           │   └── MainActivity.kt
│           └── res/
└── build.gradle.kts
````

---

## 🧭 Fitur Aplikasi

### 1. Home Screen

Menu utama berisi 4 demo navigasi:

* Start Activity
* Send Data
* Back Stack
* Activity + Fragment

### 2. Explicit Intent (Activity A → B)

Menampilkan perpindahan layar menggunakan Intent eksplisit dan pengelolaan Back Stack.

### 3. Send Data (Activity C → D)

Form input Nama dan NIM yang dikirim ke layar detail menggunakan argumen Navigation Compose.

### 4. Back Stack Demo

Navigasi bertahap (Step 1 → Step 2 → Step 3) dengan Progress Indicator dan kontrol Back Stack.

### 5. Hub (Activity + Fragment Style)

Bottom Navigation dengan:

* Dashboard
* Messages
* Message Detail
* Profile

### 6. Tema & Lokalisasi

* Light / Dark / System Theme
* Bahasa Indonesia & Inggris

---

## ▶️ Cara Menjalankan Project

1. Clone repository ini
2. Buka project di **Android Studio**
3. Pastikan:

    * JDK 17 aktif
    * Gradle Sync berhasil
4. Jalankan di Emulator atau Perangkat Android

---

## 🧪 File Hasil Uji

Folder **hasiluji/** berisi **14 file screenshot** sebagai bukti bahwa seluruh fitur aplikasi telah diuji dan berjalan dengan baik.

### Hasil Uji:
**Home Screen** ![201](hasiluji/1.png) 
**Activity A** ![200](hasiluji/2.png) 
**Activity B** ![400](hasiluji/3.png) 
**Activity C** ![401](hasiluji/4.png)
**Activity D** ![201](hasiluji/5.png)
**Back Stack – Step 1** ![200](hasiluji/6.png)
**Back Stack – Step 2** ![400](hasiluji/7.png)
**Back Stack – Step 3** ![401](hasiluji/8.png)
**Hub – Dashboard** ![201](hasiluji/9.png)
**Hub – Message** ![200](hasiluji/10.png)
**Hub – Message Detail** ![400](hasiluji/11.png)
**Hub – Message Detail** ![401](hasiluji/12.png)
**Hub – Message Detail** ![201](hasiluji/13.png)
**Hub – Profile** ![200](hasiluji/14.png)

### Keterangan Hasil Uji:

1. Home Screen
2. Activity A
3. Activity B
4. Activity C
5. Activity D
6. Back Stack Step 1
7. Back Stack Step 2
8. Back Stack Step 3
9. Dashboard (Hub)
10. Messages (Hub)
11. Message Detail
12. Message Detail
13. Message Detail
14. Profile (Hub)

---

## 🧪 Checklist Pengujian

* [x] Navigasi Home berjalan
* [x] Intent Activity A → B
* [x] Pengiriman data C → D
* [x] Back Stack Step 1–3
* [x] Bottom Navigation Hub
* [x] Tema & lokalisasi aktif

---

## Kesimpulan
Dari praktikum Mobile Programming #04 – App Navigation, dapat disimpulkan bahwa penggunaan Jetpack Compose Navigation memudahkan proses pembuatan dan pengelolaan navigasi pada aplikasi Android. Melalui praktikum ini, penulis dapat memahami cara berpindah antar layar, mengirim data antar Activity, serta mengelola back stack dengan benar.

Aplikasi yang dibuat berhasil menerapkan beberapa jenis navigasi, seperti explicit intent, pengiriman data menggunakan Navigation Compose, navigasi bertahap (step 1–3), serta Bottom Navigation yang menyerupai penggunaan fragment dalam satu Activity. Seluruh fitur tersebut telah diuji dan ditunjukkan melalui 14 hasil uji yang membuktikan bahwa aplikasi berjalan dengan baik.

Dengan adanya praktikum ini, penulis memperoleh pemahaman yang lebih baik tentang konsep navigasi aplikasi Android modern dan dapat menerapkannya sebagai dasar dalam pengembangan aplikasi Android selanjutnya.