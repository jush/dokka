package renderers.html

import org.jetbrains.dokka.base.renderers.html.HtmlRenderer
import org.jetbrains.dokka.pages.ListStyle
import org.junit.jupiter.api.Test
import renderers.testPage
import utils.Dd
import utils.Dl
import utils.Dt
import utils.match


class ListStylesTest : HtmlRenderingOnlyTestBase() {

    @Test
    fun `description list render`() {
        val page = testPage {
            descriptionList {
                item(styles = setOf(ListStyle.DescriptionTerm)) {
                    text("Description term #1")
                }
                item(styles = setOf(ListStyle.DescriptionTerm)) {
                    text("Description term #2")
                }
                item(styles = setOf(ListStyle.DescriptionDetails)) {
                    text("Description details describing terms #1 and #2")
                }
            }
        }


        HtmlRenderer(context).render(page)
        renderedContent.match(
            Dl(
                Dt("Description term #1"),
                Dt("Description term #2"),
                Dd("Description details describing terms #1 and #2")
            )
        )
    }
}
