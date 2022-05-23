# SAE 2.03 : Docker et Github

[editor on GitHub](https://github.com/RomainHauet/docker-sae203/edit/gh-pages/index.md) 

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Les attendus

- Apprendre à utiliser les conteneurs, _Docker_ et _Dockerfile_
- Apprendre à utiliser _Github_ 
- Faire un conteneur permettant la facilitation

#### Ce que nous avons fait

- Un début de site internet permettant le partage de fichier, mais abandon
- Un site de streaming vidéo

Pour lancer le site :

```
  (docker ps
  puis)
  docker build -t [nom de votre image]
  puis
  docker run --name [nom du conteneur] -d -p [port choisie]:8096 [nom de votre image]
  et enfin, sur un navigateur
  http://di-docker:[port choisie]
```
