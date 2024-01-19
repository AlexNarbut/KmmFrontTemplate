import UIKit
import SwiftUI
import ComposeApp

@main
struct iosApp: App {
    init() {
        KoinHelperKt.doInitKoin()
    }
    
    @Environment(\.scenePhase)
    var scenePhase : ScenePhase
    
    @UIApplicationDelegateAdaptor(AppDelegate.self)
    var appDelegate: AppDelegate
    
    var rootHolder : RootHolder { appDelegate.rootHolder }

    var body: some Scene {
        WindowGroup {
            RootView(root : rootHolder.root)
                .onChange(of: scenePhase) { newPhase in
                    switch newPhase {
                    case .background: LifecycleRegistryExtKt.stop(rootHolder.lifecycle)
                    case .inactive: LifecycleRegistryExtKt.pause(rootHolder.lifecycle)
                    case .active: LifecycleRegistryExtKt.resume(rootHolder.lifecycle)
                    @unknown default: break
                    }
                }
        }
    }
}

class AppDelegate : NSObject, UIApplicationDelegate {
    let rootHolder : RootHolder = RootHolder()
}


struct RootView: UIViewControllerRepresentable {
    let root: RootComponentChildStack
    
    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController(root: root)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
