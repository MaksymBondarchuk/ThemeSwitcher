package bss.themeswitcher

import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.util.Consumer
import java.awt.event.MouseEvent
import javax.swing.JComponent

class ThemeSwitcherStatusBarWidget : StatusBarWidget, StatusBarWidget.TextPresentation {
    override fun ID(): String = "ThemeSwitcherStatusBarWidget"

    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun install(statusBar: com.intellij.openapi.wm.StatusBar) {}

    override fun dispose() {}

    override fun getText(): String = "Switch Theme"

    override fun getAlignment(): Float = JComponent.CENTER_ALIGNMENT

    override fun getTooltipText(): String = "Click to switch theme"

    override fun getClickConsumer(): Consumer<MouseEvent>? = Consumer {
        ThemeSwitcherUtil.switchTheme()
    }
}