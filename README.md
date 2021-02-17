# MandelbrotSet

The Mandelbrot Set fractal is a classic programming project. Using the properties of complex numbers and some colourful organization of pixels, incredible fractal images may be produced. 

The process begins by converting and mapping over 2 million individual pixels onto the complex plane (1080 px by 1920 px screen). Then, each complex coordinate is checked to see whether or not it belongs to the Mandelbrot Set. 

The colour of each pixel is set depending on the number of iterations it takes to 'escape' the set. This is a key aspect of the visual appeal and is performed by altering the hue, satuation, and brightness (HSB) properties of the image.

Along with the image itself, the GUI has the following interactive features:
- Translation across the image using arrow keys 
- Zooming in and out of the image
- Current coordinate location of the cursor (e.g. [1.05, -4.25i] or [1.05, -4.25j] for all my electrical engineers out there)
