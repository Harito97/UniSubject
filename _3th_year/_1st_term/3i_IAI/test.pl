child(oscar,karen,franz).
child(mary,karen,franz).
child(eva,anne,oscar).
child(henry,anne,oscar).
child(isolde,anne,oscar).
child(clyde,mary,oscar).

child(X,Z,Y) :- child(X,Y,Z).
child(X,Z,Y) :- child(X,Z,Y).

descendant(X,Y) :- child(X,Y,Z).
descendant(X,Y) :- child(X,U,V), descendant(U,Y).