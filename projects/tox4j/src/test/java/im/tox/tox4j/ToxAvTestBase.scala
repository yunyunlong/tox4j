package im.tox.tox4j

import im.tox.tox4j.core.ToxCoreFactory
import im.tox.tox4j.impl.jni.{ToxAvImpl, ToxCoreImpl}

object ToxAvTestBase {

  final val enabled = {
    try {
      ToxCoreFactory.withTox { tox =>
        new ToxAvImpl[Unit](tox.asInstanceOf[ToxCoreImpl[Unit]]).close()
        true
      }
    } catch {
      case _: UnsatisfiedLinkError => false
    }
  }

}
