nombre = ["sofia", "karen", "lucila",
          "julián", "mayra"]
nota = [2.5, 3.2, 0.1, 4.9, 3]
recursos = [10, 20, 15, 30, 25]

# 1. Empiezan con "m" - con for normal
filtro = []
for n in nombre:
    if n[0] == "m":
        filtro.append(n)
print("filtro:", filtro)

# 2. Mismo pero en una sola línea
f2 = [n for n in nombre if n[0] == "m"]
print("f2:", f2)

# 3. Nombres con más de 5 letras
f3 = [n for n in nombre if len(n) > 5]
print("f3:", f3)

# 4. Notas aprobadas
f4 = [z for z in nota if z >= 3]
print("f4:", f4)

# 5. Nombres que aprobaron
f5 = [nombre[i] for i in range(len(nombre)) if nota[i] >= 3]
print("f5:", f5)

# 6. Recursos mayores a 20
f6 = [r for r in recursos if r > 20]
print("f6:", f6)
