#!/bin/bash

clear

echo ===== PULL/UPDATE ALMOND IMAGE =====
docker pull almondsh/almond

echo ===== RUN CONTAINER =====
BOOKSDIR=$(dirname `pwd`)
docker run -p 8888:8888 -v $BOOKSDIR:/home/jovyan/work almondsh/almond
### in case of "permission error" for the work directory
### please use the following command instead (i.e. add ":z" after the directory name):
# docker run -p 8888:8888 -v $BOOKSDIR:/home/jovyan/work:z almondsh/almond
