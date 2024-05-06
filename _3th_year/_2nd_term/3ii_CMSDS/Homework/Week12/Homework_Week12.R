## 6.6 (Gibbs sampling for a Poisson/gamma model).
#Suppose the vec- tor of random variables (X,Y ) has the joint density function f(x,y) =xa+y−1e−(1+b)xba y!Γ(a) , x \> 0,y = 0,1,2,... and we wish to simulate from this joint density.
#a.  Show that the conditional density f(x\|y) has a gamma density and identify the shape and rate parameters of this density.
#b.  Show that the conditional density f(y\|x) has a Poisson density.
#c.  Write a R function to implement Gibbs sampling when the constants are given by a = 1 and b = 1.
#d.  Using your R function, run 1000 cycles of the Gibbs sampler and from the output, display (say, by a histogram) the marginal probability mass function of Y and compute E(Y ).
