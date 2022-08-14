<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: INFORME DE LABORATORIO</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>
<div align="center">
<span style="font-weight:bold;">GUÍA DE LABORATORIO</span><br />
</div>

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Hash</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>07</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>10-Agosto-2022</td><td>FECHA FIN:</td><td>14-Agosto-2022</td><td>DURACIÓN:</td><td>02 horas</td>
</tr>
<tr><td colspan="6">RECURSOS:
    <ul>
       <li> Weiss M., Data Structures & Problem Solving Using Java, 2010, Addison-Wesley.
       <li>https://www.cpp.edu/~ftang/courses/CS240/lectures/hashing.htm
    </ul>    
</td>
</<tr>
  <tr><td colspan="6">ALUMNO:
<ul>
<li>Frank's Vilca Quispe - fvilcaqui@unsa.edu.pe</li>
</ul>
</td>
</<tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tdbody>
</table>
#
   ## SOLUCION Y RESULTADOS
#

## I. SOLUCION DE EJERCICIOS/PROBLEMAS

- Para evitar Colisiones Primero lo resolveremos por encadenamiento:

- Por ello primero usaremos la clase “User” donde estarán nuestros datos que guardaremos, con esta clase guardaremos los datos, como si fuese una especie de nodos.

        public class User {
	       private int key;
	       private Object value;
	       private String email;
	       User next;

- Método constructor de la llave y el valor
	
               public User (Integer key, Object value) {
		      this.key = key;
		      this.value = value;
		      next = null;
	        }


- Método constructor para crear un nodo vacío
	
                public User () {
		        next = null;
	        }


-Método constructor para crear con el valor y el e mail, como en el ejercicio que nos dejó.
	
                public User (int pId, String pName, String pEmail) {
		          key = pId;
		          value = pName;
		          email = pEmail;
	        }


- Método para conseguir el hash 	
               
	       public int hashCode() {
	                 final int prime = 31;
	                 int result = key;
	                 result = prime * result + ((email == null) ? 0 : email.hashCode());
	                 result = prime * result + (int) (key ^ (key >>> 32));
	                 result = prime * result + ((value == null) ? 0 : value.hashCode());
	                 return result;
	      }


- Método Para devolver la llave que está en el nodo
	
              public int getKey() {
		         return key;
	     }


- Método para devolver el valor dentro del nodo
	
             public Object getValue() {
	         	return value;
	    }


- Metodo para ingresar el valor
	
            public void setValue(Object valor) {
	        	value = valor;
	    }
	
	
- Metodo para devolver el email
	
            public String getEmail() {
		        return email;
	    }


- Clase Hash Encadenamiento:

           public class hashEncad<T> implements HashTable{
	              User[] Hash;
	              int tamaño,cantidad;

- Constructor de la clase hashEncad
	
            public hashEncad(int tamaño) {
		       this.tamaño = tamaño;
		       Hash = new User[tamaño];
		       for(int i=0;i<tamaño;i++) {
		       Hash[i] = new User();
		       }
	   }


- Método para que conseguir la cantidad de valores que se habia ingresado
	
            public int size() {
		       return cantidad;
	    }


- Método para saber si se tiene valores dentro o no
	
            public boolean isEmpty() {
	        	if(Hash.length>0)
		        	return true;
		       return false;
	    }


- Con este método Buscaremos una llave 

            public boolean containsKey(Integer key) {

- Si la key ingresada es null mandaremos una exception
	    
                         if (key == null) throw new NullPointerException("argument to get() is null");
	                     return SearchKey(key);
	            }


- Con este método buscaremos un valor

           public boolean containsValue(Object value) {
	   
- Si el value ingresado es null mandaremos unaException.
	
                        if (value == null) throw new NullPointerException("argument to get() is null");
	                     return SearchVal(value);
	            }



- Con este método hallaremos el hash del valor   
	
                  public Integer get(Integer key) {

- Devolveremos el mod entre key y tamaño
	
                            return key%tamaño;
	          }


 - Con ayuda de este método ingresaremos un valor
	
                 Public void put(Integer key, Object value) {
 
 - Con esto guardaremos el hash en el que sera guardado
	
                        int HashIndex = get(key); 

- Con esto lo conectamos a nuestra clase user que esta guardado en la posición de nuestro hash

                        User ArrayValor = Hash[HashIndex];
			
- Con esta parte crearemos el Nuevo objeto key y value
	
                        User newItem = new User(key , value);

- Copiaremos los valores del arraValor.next en el siguiente espacio de un NuevoItem

              	        newItem.next = ArrayValor.next;

- y en ArrayValor.next le daremos los valores del User anteriormente creado.

                        ArrayValor.next = newItem;

- Aumentaremos la cantidad de valores
   
                        cantidad ++;
	          }


- Con este método eliminaremos un valor
	
          public void remove(Integer key) {
                 T value = null;
      
- Con esto hallaremos el hash en el que está el valor que estamos buscando

		int HashIndex = get(key);
    
- Copiaremos los valores del hash buscado en ArrayValor

		User ArrayValor = Hash[HashIndex];
    
- Mientras que no sea null seguiremos recorriendo todos los ArrayValor hasta encontrar el valor que pedimos

		while(ArrayValor != null) {
    
- Si la llave del array es igual al que pedimos se eliminara

		if(ArrayValor.getKey()==key) {
		       ArrayValor.setValue(null);
           
- Disminuira la cantidad de valores ingresados

		       cantidad--;
		       break;
		  }
			ArrayValor = ArrayValor.next;
		  }
	    }

- Con este método eliminaremos todos los valores

                  public void clear() {
      
- Con este for recorreremos todos los valores del hash

		      for(int key=0;key<tamaño;key++) {
			     T value = null;
			     int HashIndex = get(key);
			     User ArrayValor = Hash[HashIndex];
			     while(ArrayValor != null) {
				     ArrayValor.setValue(null);
        
- En cada valor encontrado le daremos el valor null de esa manera, borraremos el valor antes dado.
			
                              }
				ArrayValor = ArrayValor.next;
		        }
	          } 


- Este es un método extra a los que nos pidieron, pero se usara para buscar un valor
- El método de búsqueda es igual al de remove, solo que al encontrar el valor lo guardaremos en value y cuando lo encontremos lo retornaremos  

	        public T Search(int key) {
		     T value = null;
		     int HashIndex = get(key);
		     User ArrayValor = Hash[HashIndex];
		     while(ArrayValor != null) {
			   if(ArrayValor.getKey()==key) {
		              value = (T) ArrayValor.getValue();
		              break;
			    }
			     ArrayValor = ArrayValor.next;
		      }
		       return value;
	          }

- Este método trabajara con el containskey y buscaremos un valor
- Este método será igual al de Search solo que cuando se encuentre terminara el while y se devolverá true si nunca se encuentra devolveremos false

	        public boolean SearchKey(int key) {
		        T value = null;
		        int HashIndex = get(key);
		        User ArrayValor = Hash[HashIndex];
		        while(ArrayValor != null) {
			       if(ArrayValor.getKey()==key) {
		               value = (T) ArrayValor.getValue();
		               return true;
			       }
			ArrayValor = ArrayValor.next;
		        }
		        return false;
	         }

- Este método trabajara con el containsVal y buscaremos un valor
- Este método será igual al de Search solo que cuando se encuentre terminara el while y se devolverá true si nunca se encuentra devolveremos false

                  public boolean SearchVal(Object valor) {
		          for(int key=0;key<tamaño;key++) {
			         T value = null;
			         int HashIndex = get(key);
			         User ArrayValor = Hash[HashIndex];
			         while(ArrayValor != null) {
				      if(ArrayValor.getValue()==valor) {
			                  return true;
				      }
				 ArrayValor = ArrayValor.next;
			         }
		           }
		          return false;
	          }
            }

Ejemplo:

![image](https://user-images.githubusercontent.com/87882802/184555745-0c4f2b04-0907-408e-b214-5ddfbaf423f4.png)
![image](https://user-images.githubusercontent.com/87882802/184555753-ced960f6-8d05-4e30-be2d-6cf1b8958c20.png)


- Resolveremos la colisión por sondeo Lineal:
- Clase Hash Sonde

           public class HashSonde implements HashTable{
	            private int Tamaño, maxSize=10;
                    private Integer[] keys;
                    private Object[] value;

- Constructor de la clase HashSonde

                    public HashSonde(){
                         Tamaño = 0;
                         keys = new Integer[maxSize];
                         value = new Object[maxSize];
                    }

- Método para hallar la cantidad de valores.

	            public int size() {
                  	 return Tamaño; 
	            }

- Método para saber si esta vacio nuestro arreglo.

	            public boolean isEmpty() {
    	                 return size() == 0; 
	            }

- Con este metodo Buscaremos una llave 

           	   public boolean containsKey(Integer key) {
	
- Si la key ingresada es null mandaremos una exception

		         if (key == null) throw new NullPointerException("argument to get() is null");
		            return SearchKey(key) != null;
	                 }

- Con este método Buscaremos un valor

         	 public boolean containsValue(Object value) {
  
- Si el value ingresado es null mandaremos una exception

	                if (value == null) throw new NullPointerException("argument to get() is null");
		           return false;
	                }

- Metodo para hallar el hash

         	 public Integer get(Integer key) {
		         return key.hashCode() % maxSize;
	         }

- Metodo para ingresar un valor

	         public void put(Integer key, Object valor) {
  
- en tmp guardaremos el hash hallado con el método get

	                 int tmp = get(key);
       
- este valor se guardará en i

	                 int i = tmp;
	                 do {
          
- en caso keys sea igual a null, daremos todos los valores ingresados, tanto de key como valor 

	                   if (keys[i] == null) {
	                       keys[i] = key;
	                       value[i] = valor;
	                       Tamaño++;
	                       return;
	                  }
              
- Si keys ya tenía un valor anteriormente solo guardaremos el value

	                   if (keys[i].equals(key)) {
	                       value[i] = valor;
	                       return;
	                   }
              
- Con este método recorreremos al siguiente espacio en caso el actual este ocupado

	                    i = (i + 1) % maxSize;
	               }
          
- Con esto evitaremos que el i sea igual a temp en caso no se guarde aun el valor

	              while (i != tmp);		
	       }

- Metodo para eliminar un valor


         	 public void remove(Integer key) {
	              if (!containsKey(key))
	                  return;	 
              
- Guardamsos el hash en i

	              int i = get(key);
	              while (!key.equals(keys[i]))
	                   i = (i + 1) % maxSize;
              
- Una vez encontrado el valor le daremos los valores null

	                  keys[i] = null; 
	                  value[i] = null;
	                  for (i = (i + 1) % maxSize; keys[i] != null;i = (i + 1) % maxSize) {
	                          int tmp1 = keys[i];
	                          Object tmp2 = value[i];
	                          keys[i] = null; 
  		                  value[i] = null;
            
- Buscaremos los valores que estaban luego de nuestro valor eliminado y los volveremos a ingresar para no dejar espacios vacios.

	                         Tamaño--;
	                         put(tmp1, tmp2);
	                  }
	                        Tamaño--;
	            }

- Método para limpiar todos los valores

         	 public void clear() {
  
- regresaremos el tamño a cero

                        Tamaño = 0;
        
- Crearemos lo array desde cero

                        keys = new Integer[maxSize];
                        value = new String[maxSize];
	         }
	   
- Metodo para buscar la key

               public Object SearchKey(Integer key){
    
- guardaremos el hash en i

                       int i = get(key);
        
- si la key en posicion I no es nulo continuaremos con el while

                       while (keys[i] != null) {
        
- una vez encontrado el keys[i] sea igual a key devolveremos el valor.

                            if (keys[i].equals(key))
                                return value[i];
                            i = (i + 1) % maxSize;
                      }
                      return null;
               } 

-  Con este método imprimiremos todo el hash

         	 public void Imprimir(){
                      System.out.println("\nHash Table: ");
                      for (int i = 0; i < maxSize; i++)
        
- recorreremos todos los array y mientras que no sean nulos los imprimiríamos

                      if (keys[i] != null)
                          System.out.println(keys[i] + " " + value[i]);
                      System.out.println();
                 }
          }

- Ejemplo:
 ![image](https://user-images.githubusercontent.com/87882802/184555927-4716c529-8cbb-40fd-a673-1a666be6445c.png)
![image](https://user-images.githubusercontent.com/87882802/184555934-29e40b46-4c11-457b-8f56-99e4c3f0ba69.png)

 

