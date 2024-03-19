/*
 * Copyright 2023 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.idea.blaze.ext;

import com.google.idea.blaze.ext.platform.IntelliJExtsDefault;
import com.google.idea.blaze.ext.platform.IntelliJExtsMac;

import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * Static utility methods relating to {@link IntelliJExtClient} and {@link IntelliJExtTestServer}.
 * Delegates to platform-specific implementations.
 */
public final class IntelliJExts {

  private static boolean isMac() {
    return System.getProperty("os.name").equals("Mac OS X");
  }

  public static EventLoopGroup createGroup(DefaultThreadFactory threadFactory) {
    if (IntelliJExts.isMac()) {
      return IntelliJExtsMac.createGroup(threadFactory);
    } else {
      return IntelliJExtsDefault.createGroup(threadFactory);
    }
  }

  public static Class<? extends Channel> getClientChannelType() {
    if (IntelliJExts.isMac()) {
      return IntelliJExtsMac.getClientChannelType();
    } else {
      return IntelliJExtsDefault.getClientChannelType();
    }
  }

  public static Class<? extends ServerChannel> getServerChannelType() {
    if (IntelliJExts.isMac()) {
      return IntelliJExtsMac.getServerChannelType();
    } else {
      return IntelliJExtsDefault.getServerChannelType();
    }
  }
}
