package com.example.calculadorrmgym;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etKg, etRepes, etResultado;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vinculación con los elementos del XML
        etKg = findViewById(R.id.etKg);
        etRepes = findViewById(R.id.etRepes);
        etResultado = findViewById(R.id.etResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        // Evento de clic para el botón
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etNumeroKilos = etKg.getText().toString();
                String etNumeroRepes = etRepes.getText().toString();

                // Verificar que los campos no estén vacíos
                if (etNumeroKilos.isEmpty() || etNumeroRepes.isEmpty()) {
                    etResultado.setText("Ingrese un número");
                    return; // Salir del método para evitar errores
                }

                try {
                    double kilos = Double.parseDouble(etNumeroKilos);
                    double repes = Double.parseDouble(etNumeroRepes);

                    // Cálculo del RM
                    double calculoRm = (kilos * 0.033 * repes) + kilos -1 ;

                    // Mostrar el resultado correctamente
                    etResultado.setText(String.format("%.1f", calculoRm));
                } catch (NumberFormatException e) {
                    etResultado.setText("Escribe bien tontito");
                }
            }
        });
    }
}
