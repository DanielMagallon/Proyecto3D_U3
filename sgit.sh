#!/bin/bash

echo "# Proyecto3D_U3" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/DanielMagallon/Proyecto3D_U3.git
git push -u origin main
