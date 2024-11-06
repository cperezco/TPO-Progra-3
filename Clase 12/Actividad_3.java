class Almacen:
    def __init__(self, id, nombre):
        self.id = id
        self.nombre = nombre

class Grafo:
    def __init__(self):
        self.almacenes = {}  
        self.adyacencia = {} 

    def agregar_almacen(self, id, nombre):
        almacen = Almacen(id, nombre)
        self.almacenes[id] = almacen
        self.adyacencia[id] = []

    def conectar_almacenes(self, id1, id2):
        self.adyacencia[id1].append(id2)
        self.adyacencia[id2].append(id1)

    def dfs(self, inicio, visitado=None):
        if visitado is None:
            visitado = set()
        print(self.almacenes[inicio].nombre)
        visitado.add(inicio)
        for vecino in self.adyacencia[inicio]:
            if vecino not in visitado:
                self.dfs(vecino, visitado)

    def bfs(self, inicio):
        visitado = set()
        cola = [inicio]
        visitado.add(inicio)

        while cola:
            nodo = cola.pop(0)
            print(self.almacenes[nodo].nombre)
            for vecino in self.adyacencia[nodo]:
                if vecino not in visitado:
                    visitado.add(vecino)
                    cola.append(vecino)

# Ejemplo de uso
red = Grafo()
red.agregar_almacen(0, "Almacen Central")
red.agregar_almacen(1, "Almacen Norte")
red.agregar_almacen(2, "Almacen Sur")
red.conectar_almacenes(0, 1)
red.conectar_almacenes(0, 2)

print("DFS desde Almacen Central:")
red.dfs(0)

print("\nBFS desde Almacen Central:")
red.bfs(0)
