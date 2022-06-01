# Polimorfismo

1. Uma possível forma de definir polimorfismo em uma frase é: polimorfismo é a existência de uma mesma interface para entidades de tipos diferentes[<sup>[referência]</sup>](https://www.stroustrup.com/glossary.html#Gpolymorphism).

Outra possível definição em uma frase seria: a palavra "polimorfismo" refere-se a um conjunto de diferentes funcionalidades (os diferentes tipos de polimorfismo), que têm em comum a característica de que objetos de tipos diferentes se comportam de maneiras semelhantes.

---

2. Diferentes tipos de polimorfismo têm diferentes utilidades. A seguir alguns tipos de polimorfismo, com algumas possíveis utilidades:

- polimorfismo ad hoc de sobrecarga: permite a criação de vários métodos diferentes, cada um com sua implementação, mas todos com o mesmo nome; é o que permite por exemplo que se possa mostrar na tela diferentes tipos de dados usando `System.out.println()`.

- Polimorfismo paramétrico: permite criação de estruturas de dados de tipos genéricos.

- Subtipagem: permite a escrita de código mais genérico, que pode ser aproveitado para dados de tipos diferentes; por exemplo `Object.equals(Object obj)` pode receber como argumento um objeto de qualquer classe.

---

3. `Cachorro nomeDaVariavel = new Cachorro();`

`Animal nomeDaVariavel = new Cachorro();`

`Object nomeDaVariavel = new Cachorro();`

---

4. Opção a, V.

---

5. Opção a, V.

---

6. Opção a, V.

---

7. Fazendo `Cachorro cachorro = new Cachorro()`, estarão disponíveis os métodos alimentar, respirar, brincar, comunicar.

---

8. `alimentar`.

---

9. Se o método `Object.toString()` não estiver sobrescrito, `System.out.println(aluno)` implicitamente aplica o método `Object.toString()` a aluno. Por sua vez o método `Object.toString()` está definido para retornar algo como o citado no enunciado, uma string que representa o objeto, criada a partir do nome da classe do objeto, e do código hash do objeto em hexadecimal.

---

10. Uma opção:

```Java
@Override
public String toString() {
    return "Aluno = {nome = " + this.nome + ", matrícula = " + this.matrícula + "}";
}
```
