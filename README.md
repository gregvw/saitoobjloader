# saitoobjloader
Automatically exported from code.google.com/p/saitoobjloader

The Saito object loader has been available as a Processing library for a long time,
however, it appears that there are some outstanding issues that need attention to 
be fully functional. Since the source code depends on a deprecated Java OpenGL, it
can not be easily compiled with modern libraries.

This project replaces the old dependency on javax.media.opengl with an new 
required implementation from [LWJGL](https://www.lwjgl.org/).
