package prudentia

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import prudentia.json.ExportDepute
import java.io.File

class DeputesSpec {
    var result:ExportDepute? = null;

    @Before
    fun before () {
        val JSON = jacksonObjectMapper()
        val file = File("src/test/testfiles/test_deputes.json")
        result = JSON.readValue<ExportDepute>(file)
    }

    @Test
    fun testLectureFichier() {
        Assert.assertNotNull(result)
    }

    @Test
    fun testLectureFichierEtRecuperation() {
        Assert.assertNotNull(result)
        Assert.assertEquals(result?.export?.acteurs?.acteur?.size?.compareTo(500), 1)
        Assert.assertEquals(result?.export?.acteurs?.acteur?.size?.compareTo(700), -1)
    }

    @Test
    fun testLectureFichierEtDonneesActeur() {
        Assert.assertNotNull(result?.export?.acteurs?.acteur?.get(0))
        Assert.assertNotNull(result?.export?.acteurs?.acteur?.get(0)?.adresses)
        Assert.assertNotNull(result?.export?.acteurs?.acteur?.get(0)?.adresses?.adresse)
        Assert.assertEquals(result?.export?.acteurs?.acteur?.get(0)?.adresses?.adresse?.size?.compareTo(0), 1)
    }
}