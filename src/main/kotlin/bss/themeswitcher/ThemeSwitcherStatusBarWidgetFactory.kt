package bss.themeswitcher

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

class ThemeSwitcherStatusBarWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = "ThemeSwitcherStatusBarWidgetFactory"

    override fun getDisplayName(): String = "Theme Switcher"

    override fun isAvailable(project: Project): Boolean = true

    override fun createWidget(project: Project): StatusBarWidget = ThemeSwitcherStatusBarWidget()

    override fun disposeWidget(widget: StatusBarWidget) {}

    override fun canBeEnabledOn(statusBar: com.intellij.openapi.wm.StatusBar): Boolean = true
}