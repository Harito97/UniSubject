# import
import gurobipy as gp
from gurobipy import GRB

model = gp.Model("")

# lb, up, vtype, name
# nhi phan, nguyen, lien tuc(thuc)
x1 = model.addVar(lb = 0, ub = GRB.INFINITY, vtype = GRB.CONTINUOUS)
x2 = model.addVar(lb = 0, ub = GRB.INFINITY, vtype = GRB.CONTINUOUS)
x3 = model.addVar(lb = 0, ub = GRB.INFINITY, vtype = GRB.CONTINUOUS)
x4 = model.addVar(lb = 0, ub = GRB.INFINITY, vtype = GRB.CONTINUOUS)

model.addConstr(-1 * x1 + -1 * x2 <= -2)
model.addConstr(-1 * x1 + 1 * x2 <= 0)
model.addConstr(1 * x1 + 0 * x2 <= 3)
model.addConstr(1 * x1 + 1 * x2 <= 4)
model.setObjective(1 * x1 + 2 * x2, sense = GRB.MAXIMIZE)

# Call back
model.optimize()

print("\n-------------------")
print(model.objVal)
model.printAttr("x")
#vars = model.addMVar(3)
#model.optimize()
#print(vars.x)
