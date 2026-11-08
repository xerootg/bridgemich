# Bridgemich
**An image picker for [Immich](https://immich.app/).**

[![forgejo upstream](https://img.shields.io/badge/forgejo-upstream-orange?logo=forgejo)](https://fj.tarakoshka.tech/tarakoshka/bridgemich)
[![github mirror](https://img.shields.io/badge/github-mirror-blue?logo=github)](https://github.com/yaroslav-belozerov/bridgemich/)

---

Allows you to use Immich when choosing photos in apps, similar to a gallery app.  
Only displays images which are backed up.  
Without this you have to download photo on Immich and then search for it again.

---

### Downloads
> [Download latest APK](https://fj.tarakoshka.tech/tarakoshka/bridgemich/releases/download/latest/app-release.apk) from Forgejo  
> Android 7.0+  

<img height="200px" src="misc/screenshots/screenshot1.jpg"/>
<img height="200px" src="misc/screenshots/screenshot2.jpg"/>

### License
This project is licensed under the Apache 2.0 Software License.  
This application is not affiliated with the Immich project. All trademarks and brand names belong to their respective owners.

### Signing (this fork)
Every build is signed with one release key so installs can always be updated
in place. CI reads it from the repo secrets (`KEYSTORE_BASE64`,
`KEYSTORE_PASSWORD`, `KEY_ALIAS`, `KEY_PASSWORD`) and fails if the APK's
certificate isn't the pinned one (`EXPECTED_CERT_SHA256` in
`.github/workflows/build.yml`). For a local build with the same key, create a
gitignored `keystore.properties` at the repo root with `storeFile`,
`storePassword`, `keyAlias` and `keyPassword`; debug builds then use the
release key too. Tag `vX.Y.Z` to publish a release.
