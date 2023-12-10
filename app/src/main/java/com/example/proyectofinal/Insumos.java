package com.example.proyectofinal;

    public class Insumos {
        private String nombre;
        private String valor;

        // Constructor
        public Insumos() {
            this.nombre = nombre;
            this.valor = valor;
        }

        // Getters y Setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Insumo{" +
                    " nombre='" + nombre + '\'' +
                    ", valor='" + valor + '\'' +
                    '}';
        }
    }



