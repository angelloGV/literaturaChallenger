package com.challengerLiteratura.principal;

import com.challengerLiteratura.unidadData.DatosAutor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> listaLibros;

    private String name;
    private Integer axoNacimiento;
    private Integer axoFallecimiento;


    public Autor(){}
    public Autor(DatosAutor dataAutor
    )
    {
        this.name = dataAutor.autor();
        this.axoNacimiento = dataAutor.axoNacimiento();
        this.axoFallecimiento = dataAutor.axoFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = "The data of the searched actor is:  \n"+
                "Name: "+name +"\n"+
                "Birth Year: "+ axoNacimiento + "\n"+
                "Death Year: "+ axoFallecimiento;
        return result;
    }
}
