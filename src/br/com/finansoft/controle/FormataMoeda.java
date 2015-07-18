/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.finansoft.controle;

import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author jereelton
 */
public class FormataMoeda {
    
    private final String valorInicialCampo;
    private String mascaraFormatacao;
    private final int digitosCampo;
    
    public FormataMoeda(String valor) {
        
        this.valorInicialCampo = valor.replaceAll("[^0-9]", "").replaceAll("^[0]", "");
        this.digitosCampo      = this.valorInicialCampo.length();
        
    }
    
    public String formatar() {
        
        MaskFormatter mascararValor;
        
        switch ( this.digitosCampo ) {
        
            case 0:
                this.mascaraFormatacao = "0,00";
                break;
            case 1:
                this.mascaraFormatacao = "0,0#";
                break;
            case 2:
                this.mascaraFormatacao = "0,##";
                break;
            case 3:
                this.mascaraFormatacao = "#,##";
                break;
            case 4:
                this.mascaraFormatacao = "##,##";
                break;
            case 5:
                this.mascaraFormatacao = "###,##";
                break;
            case 6:
                this.mascaraFormatacao = "#.###,##";
                break;
            case 7:
                this.mascaraFormatacao = "##.###,##";
                break;
            case 8:
                this.mascaraFormatacao = "###.###,##";
                break;
            case 9:
                this.mascaraFormatacao = "#.###.###,##";
                break;
            case 10:
                this.mascaraFormatacao = "##.###.###,##";
                break;
            case 11:
                this.mascaraFormatacao = "###.###.###,##";
                break;
            case 12:
                this.mascaraFormatacao = "#.###.###.###,##";
                break;
            case 13:
                this.mascaraFormatacao = "##.###.###.###,##";
                break;
            case 14:
                this.mascaraFormatacao = "###.###.###.###,##";
                break;
            case 15:
                this.mascaraFormatacao = "#.###.###.###.###,##";
                break;
            case 16:
                this.mascaraFormatacao = "##.###.###.###.###,##";
                break;
            case 17:
                this.mascaraFormatacao = "###.###.###.###.###,##";
                break;
            default:
                this.mascaraFormatacao = "###.###.###.###.###,##";
                JOptionPane.showMessageDialog(null, "Número máximo de digitos alcançado");
                
        }
        
        try {
            
            mascararValor = new MaskFormatter(this.mascaraFormatacao);
            mascararValor.setValueContainsLiteralCharacters(false);
            
            return mascararValor.valueToString(this.valorInicialCampo);
            
        } catch (ParseException e) {
            
            throw new RuntimeException(e);
            
        }
        
    }
    
}
