/* Copyright 2017 Esri
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For additional information, contact:
 * Environmental Systems Research Institute, Inc.
 * Attn: Contracts Dept
 * 380 New York Street
 * Redlands, California, USA 92373
 *
 * email: contracts@esri.com
 *
 */
package com.esri.arcgisruntime.opensourceapps.mapbook;

import android.content.Context;
import com.esri.arcgisruntime.opensourceapps.mapbook.download.CredentialCryptographer;
import com.esri.arcgisruntime.opensourceapps.mapbook.util.MapbookApplicationScope;
import dagger.Module;
import dagger.Provides;

/**
 * This is a Dagger module. This module passes in the Context dependency to the
 * {@link com.esri.arcgisruntime.opensourceapps.mapbook.mapbook.MapbookComponent},
 * {@link com.esri.arcgisruntime.opensourceapps.mapbook.download.DownloadComponent},
 * and {@link com.esri.arcgisruntime.opensourceapps.mapbook.map.MapComponent}
 */
@Module
public class ApplicationModule {

  private final Context mContext;

  public ApplicationModule(final Context context)
  {
    mContext = context;
  }

  @Provides
  @MapbookApplicationScope
  public Context provideContext(){
    return mContext;
  }

  @Provides
  @MapbookApplicationScope
  public CredentialCryptographer providesCredentialManager(final Context context){
    return new CredentialCryptographer( context);
  }

}
