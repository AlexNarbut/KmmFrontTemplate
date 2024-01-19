
import ComposeApp
import SwiftUI

class RootHolder : ObservableObject {
    let lifecycle: LifecycleRegistry
    let root: RootComponentChildStack

    init() {
        lifecycle = LifecycleRegistryKt.LifecycleRegistry()

        root = RootComponentChildStack(
            componentContext: DefaultComponentContext(lifecycle: lifecycle)
        )

        LifecycleRegistryExtKt.create(lifecycle)
    }

    deinit {
        // Destroy the root component before it is deallocated
        LifecycleRegistryExtKt.destroy(lifecycle)
    }
}
